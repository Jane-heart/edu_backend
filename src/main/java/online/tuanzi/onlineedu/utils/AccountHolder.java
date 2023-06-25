package online.tuanzi.onlineedu.utils;


import online.tuanzi.onlineedu.model.entity.User;

/**
 * 在当前线程中获取用户对象
 */
public class AccountHolder {

    private static final ThreadLocal<User> tl =new ThreadLocal<>();

    // 存数据
    public static void saveUser(User user){
        tl.set(user);
    }

    //取数据
    public static User getUser(){
        return tl.get();
    }

    //删除数据
    public static void removeUser(){
        tl.remove();
    }

}