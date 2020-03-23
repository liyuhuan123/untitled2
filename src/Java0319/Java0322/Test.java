package Java0319.Java0322;

import java.util.Arrays;

public class Test {
    private static String userName = "admin";
    private static String password = "123456";
    public static void main(String[] args){
        try{
            login("admin","123456");
        }catch(PasswordError passwordError){
            passwordError.printStackTrace();
        }catch(UserError userError){
            userError.printStackTrace();
        }
    }
    public static void login(String userName,String password)
            throws UserError,PasswordError{
        if(!Test.userName.equals(userName)){
            throw new UserError("用户名错误");
        }
        if(!Test.password.equals(password)){
            throw new PasswordError("密码错误");
        }
        System.out.println("登陆成功");

    }
}