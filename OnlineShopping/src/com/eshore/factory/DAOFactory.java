package com.eshore.factory;


import com.eshore.dao.AddrDao;
import com.eshore.dao.CommonUserDao;
import com.eshore.dao.CorrespondDao;
import com.eshore.dao.ManagerDao;
import com.eshore.dao.OrderDao;
import com.eshore.dao.PurchaseDao;
import com.eshore.dao.ShoppingCartDao;
import com.eshore.dao.GoodDao;
import com.eshore.dao.UserDao;
import com.eshore.service.AddrService;
import com.eshore.service.CommonUsersService;
import com.eshore.service.CorrespondService;
import com.eshore.service.ManagerService;
import com.eshore.service.OrderService;
import com.eshore.service.PurchaseService;
import com.eshore.service.ShoppingCartService;
import com.eshore.service.GoodService;
import com.eshore.service.UsersService;

public class DAOFactory {
	//取得Good业务操作类
	public static GoodDao getGoodDAOInstance()throws Exception {   
        return new GoodService();   
    } 
	//取得shoppingcart业务操作类
	public static ShoppingCartDao getShoppingCartDAOInstance()throws Exception {   
        return new ShoppingCartService(); 
    }
	//取得用户业务操作类
	public static UserDao getUserDAOInstance()throws Exception {   
        return new UsersService();    
    }
	//取得购买业务操作类
	public static PurchaseDao getPurchaseDAOInstance()throws Exception{
		return new PurchaseService();
	}
	//取得购买业务操作类
	public static CommonUserDao getCommonUserDAOInstance()throws Exception{
		return new CommonUsersService();
	}
	//取得地址类
	public static AddrDao getAddrDAOInstance()throws Exception {   
        return new AddrService();    
    }
	//取得地址类
	public static CorrespondDao getCorrespondDAOInstance()throws Exception {   
        return new CorrespondService();    
    }
	//取得地址类
	public static OrderDao getOrderDAOInstance()throws Exception {   
        return new OrderService();    
    }
	//取得管理员类
	public static ManagerDao getManagerDAOInstance()throws Exception {   
        return new ManagerService();    
    }
}
