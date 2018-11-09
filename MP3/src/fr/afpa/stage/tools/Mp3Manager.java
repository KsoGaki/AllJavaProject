package fr.afpa.stage.tools;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import fr.afpa.stage.tools.Mp3ManagerException;
import fr.afpa.stage.tools.MyLengths;
import fr.afpa.stage.tools.MyOffsets;

public class Mp3Manager  {

	private String filePath;

	private File file;

	private static RandomAccessFile randomAccessFile;

	private String tag = "";
	private String title = "";
	private String artist = "";
	private String album = "";
	private String year = "";
	private String comment = "";
	private String genre = "";

	private static long lengthTag;

	public void read() throws Mp3ManagerException, IOException {
		randomAccessFile.seek(lengthTag);
		tag = secondRead(MyLengths._TAGLENGTH.getValue()).trim();
		if(tag.equals("TAG")) {
			title = secondRead(MyLengths._TITLELENGTH.getValue()).trim();
			artist = secondRead(MyLengths._ARTISTLENGTH.getValue()).trim();
			album = secondRead(MyLengths._ALBUMLENGTH.getValue()).trim();
			year = secondRead(MyLengths._YEARLENGTH.getValue()).trim();
			comment = secondRead(MyLengths._COMMENTLENGTH.getValue()).trim();
			genre = secondRead(MyLengths._GENRELENGTH.getValue()).trim();	
		}
		else {
			System.out.println(tag);
			throw new Mp3ManagerException("TAG ERROR");
		}
	}
	
	private String secondRead(int tabLenght) throws IOException, UnsupportedEncodingException {
		byte[] tabByteToString = new byte[tabLenght]; 
		randomAccessFile.read(tabByteToString);
		String toReturn = new String(tabByteToString, "UTF-8");
		toReturn.trim();
		return toReturn;
	}
	
	public void write() throws IOException {
		secondWrite(MyOffsets._TAGOFFSET.getValue(), MyLengths._TAGLENGTH.getValue(), tag);
		secondWrite(MyOffsets._TITLEOFFSET.getValue(), MyLengths._TITLELENGTH.getValue(), title);
		secondWrite(MyOffsets._ARTISTOFFSET.getValue(), MyLengths._ARTISTLENGTH.getValue(), artist);
		secondWrite(MyOffsets._ALBUMOFFSET.getValue(),MyLengths._ALBUMLENGTH.getValue(), album);
		secondWrite(MyOffsets._YEAROFFSET.getValue(), MyLengths._YEARLENGTH.getValue(), year);
		secondWrite(MyOffsets._COMMENTOFFSET.getValue(),MyLengths._COMMENTLENGTH.getValue(), comment);
		secondWrite(MyOffsets._GENREOFFSET.getValue(),MyLengths._GENRELENGTH.getValue(), genre);
	}

	private void secondWrite(int offset, int tagLength , String newTag) throws IOException{
		if(newTag.length() <= tagLength) {
			randomAccessFile.seek(randomAccessFile.length() - offset);
			while(newTag.length() < tagLength) {
				newTag += " ";
			}
			randomAccessFile.write(newTag.getBytes());
		}
		else {
			System.out.println("Your tag is too long MAX("+tagLength+")");
		}
	}

	@Override
	public String toString() {
		return "tag: " + tag.trim() 
				+ "\nTitle: " + title.trim() 
				+ "\nArtist: " + artist.trim() 
				+ "\nAlbum: " + album.trim() 
				+ "\nYear: " + year.trim()
				+ "\nComment: " + comment.trim() 
				+ "\ngenre: " + (int)genre.trim().charAt(0)
				+ "\n";
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) throws IOException {
		this.tag = tag;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws IOException {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) throws IOException {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) throws IOException {
		this.album = album;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) throws IOException {
		this.year = year;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) throws IOException {
		this.comment = comment;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) throws IOException {
		this.genre = genre;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public static RandomAccessFile getRandomAccessFile() {
		return randomAccessFile;
	}

	public Mp3Manager(String filePath) throws IOException,   Mp3ManagerException {
		super();
		this.filePath = filePath;
		file = new File(filePath);
		lengthTag = file.length() - MyOffsets._TAGOFFSET.getValue();
		randomAccessFile = new RandomAccessFile(file,"rw");
		read();
	} 
}
