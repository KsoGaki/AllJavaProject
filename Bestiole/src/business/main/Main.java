package business.main;

import persistence.dao.PersonDao;
import persistence.exception.DaoException;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws DaoException {

		//		if(false) {
		//			System.setProperty(CfgManager.getInstance().OTHER_CFG_FILE, "files/cfg.ini");
		//			Properties properties = CfgManager.getInstance().getCfg();
		//			System.out.println(properties);
		//		}
		//		else {
		//			System.setProperty(CfgManager.getInstance().EXTERNAL_CFG_FILE, "files/cfg.ini");
		//			Properties properties = CfgManager.getInstance().getCfg();
		//			System.out.println(properties);
		//		}
		System.out.println(" {\\__/}");
		System.out.println("( • - •)");
		System.out.println(" / ⊃🎂");
		System.out.println();
		System.out.println(" /﹋\\");
		System.out.println("(҂`_´)");
		System.out.println(" <,▬ι══════ﺤ");
		System.out.println(" /﹋\\﻿");
		
		PersonDao personDao = new PersonDao();
		personDao.deleteById(1);

	}
}
