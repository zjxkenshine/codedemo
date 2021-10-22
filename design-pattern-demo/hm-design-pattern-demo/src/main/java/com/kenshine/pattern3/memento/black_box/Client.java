package com.kenshine.pattern3.memento.black_box;


/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 黑箱备忘录
 * @Author: kenshine
 */
public class Client {
    public static void main(String[] args) {
        System.out.println("---------------大战boos前-----------------");
        //创建游戏角色对象
        GameRole gameRole = new GameRole();
        gameRole.initState();//初始化状态操作
        gameRole.stateDisplay();

        //将该游戏角色内部状态进行备份
        //创建管理者对象
        RoleStateCaretaker roleStateCaretaker = new RoleStateCaretaker();
        roleStateCaretaker.setMemento(gameRole.saveState());

        System.out.println("---------------大战boos后-----------------");
        //损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("---------------恢复之前的状态-----------------");
        gameRole.recoverState(roleStateCaretaker.getMemento());
        gameRole.stateDisplay();
    }
}
