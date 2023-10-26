package oopWithNLayeredApp.business;

import oopWithNLayeredApp.core.logging.Logger;
import oopWithNLayeredApp.dataAccess.HibernateProductDao;
import oopWithNLayeredApp.dataAccess.JdbcProductDao;
import oopWithNLayeredApp.dataAccess.ProductDao;
import oopWithNLayeredApp.entities.Product;

import java.util.List;

public class ProductManager {
    private ProductDao productDao;
    private List<Logger> loggers;

    public ProductManager(ProductDao productDao, List<Logger> loggers) {
        this.productDao = productDao;
        this.loggers = loggers;

    }

    public ProductManager(HibernateProductDao productDao) {
    }

    public void add (Product product) throws Exception {
        if (product.getUnitePrice()<10){
            throw new Exception("Ürün fiyatı 10 dan küçük olamaz");
        }
        /* Aşağadıki kodların yerine yukarıda prodcutdao u consructur yapılarak elde edildi
        JdbcProductDao productDao = new JdbcProductDao();
        HibernateProductDao productDao = new HibernateProductDao();
        ProductDao productDao = new HibernateProductDao();
        ProductDao productDao = new JdbcProductDao();*/
        //yukarida tum loggerlar l'st olarak cagrildi ve for dongusunde hepsine gonderildi
        productDao.add(product);
        for (Logger logger: loggers) { //[db, mail]
            logger.log(product.getName());
        }

    }
}
