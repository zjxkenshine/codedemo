package com.kenshine.pattern3.memento.white_box;

/**
 * @version v1.0
 * @ClassName: Client
 * @Description: 白箱备忘录模式
 * @Author: kenshine
 *
 * 备忘录模式优点：
 * 提供了一种可以恢复状态的机制。
 * 实现了内部状态的封装。除了创建它的发起人之外，其他对象都不能够访问这些状态信息。
 * 简化了发起人类。
 *
 * 缺点：
 * 资源消耗大。如果要保存的内部状态信息过多或者特别频繁，将会占用比较大的内存资源。
 *
 * 使用场景：
 * 需要保存与恢复数据的场景，如玩游戏时的中间结果的存档功能。
 * 需要提供一个可回滚操作的场景，如 Word、记事本、Photoshop，idea等软件在编辑时按 Ctrl+Z 组合键，还有数据库中事务操作。
 *
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
        roleStateCaretaker.setRoleStateMemento(gameRole.saveState());

        System.out.println("---------------大战boos后-----------------");
        //损耗严重
        gameRole.fight();
        gameRole.stateDisplay();

        System.out.println("---------------恢复之前的状态-----------------");
        gameRole.recoverState(roleStateCaretaker.getRoleStateMemento());
        gameRole.stateDisplay();
    }
}
