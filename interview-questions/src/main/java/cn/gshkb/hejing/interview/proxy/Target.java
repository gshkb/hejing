package cn.gshkb.hejing.interview.proxy;

/**
 * 目标类
 *
 * @author hkb
 * @create 2019-04-22 15:16 v1.0
 **/
public class Target implements IProxy {

    @Override
    public void execute() {
        System.out.println("execute target");
    }
}
