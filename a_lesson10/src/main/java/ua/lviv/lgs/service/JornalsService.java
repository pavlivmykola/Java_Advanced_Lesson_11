package ua.lviv.lgs.service;

import java.util.Map;

import ua.lviv.lgs.domain.Jornals;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface JornalsService extends AbstractCRUD<Jornals>{
	public Map<Integer,Jornals> readAllMap();
}
