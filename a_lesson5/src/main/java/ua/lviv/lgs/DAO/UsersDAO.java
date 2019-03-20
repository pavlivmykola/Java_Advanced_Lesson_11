package ua.lviv.lgs.DAO;

import ua.lviv.lgs.domain.Users;
import ua.lviv.lgs.shared.AbstractCRUD;

public interface UsersDAO extends AbstractCRUD<Users>{
	Users readByLogin(String login);
}
