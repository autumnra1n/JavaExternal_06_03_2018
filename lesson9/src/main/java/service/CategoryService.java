package service;

import persistence.dao.CategoryDao;

public class CategoryService {

    private CategoryDao categoryDao = new CategoryDao();

    public void addCategory(String name){
        categoryDao.addCategory(name);
    }

    public void deleteCategory(int id){
        categoryDao.deleteCategory(id);
    }

    public void showCategories(){
        categoryDao.showCategories();
    }
}
