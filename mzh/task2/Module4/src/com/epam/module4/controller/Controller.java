package com.epam.module4.controller;

import java.util.ArrayList;
import java.util.List;

import com.epam.module4.bridge.AbstractPrinter;
import com.epam.module4.bridge.ListBoxView;
import com.epam.module4.bridge.ListTableView;
import com.epam.module4.bridge.Printer;

public class Controller {
	
	public static void main(String[] args) {
		
		List<AbstractPrinter> printers = new ArrayList<AbstractPrinter>();
		printers.add(new Printer(27, new ListBoxView()));
		printers.add(new Printer(27, new ListTableView()));
		for (AbstractPrinter printer : printers) {
			printer.printList();
		}
	}
}
