package ua.lviv.lgs.service;

import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface UsersService extends AbstractCRUD<Users>{
	Users readByLogin(String login);
}
