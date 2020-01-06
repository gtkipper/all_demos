package com.timer.command;

/**
 * @author kipper_yuhaibo
 * @create 2020-01-05 22:00
 * @description 命令模式
 */
public class TestCommand {
    public static void main(String[] args) {
        Invoker invoker = new Invoker(new ConcreteCommand());
        invoker.call();
    }
}

/**
 * 调用者（命令的请求者）
 */
class Invoker {
    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
    public void call() {
        System.out.println("调用者执行命令command...");
        command.execute();
    }
}

/**
 * 抽象命令角色
 */
interface Command {
    public abstract void execute();
}

/**
 * 具体命令角色
 */
class ConcreteCommand implements Command {
    private Receiver receiver;

    public ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        System.out.println("具体命令角色执行命令execute()方法被调用。。。");
        receiver.execute();
    }
}

/**
 * 接收者（命令的实现者）
 */
class Receiver {
    public void execute() {
        System.out.println("接收者的execute()方法被调用。。。");
    }
}

