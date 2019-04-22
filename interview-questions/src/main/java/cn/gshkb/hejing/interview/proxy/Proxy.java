package cn.gshkb.hejing.interview.proxy;

/**
 * 代理类
 *
 * @author hkb
 * @create 2019-04-22 15:15 v1.0
 **/
public class Proxy implements IProxy{

	private IProxy target;

	public Proxy(IProxy  target){
		this.target = target;
	}

	@Override
	public void execute() {
		System.out.println("execute proxy before");
		target.execute();
		System.out.println("execute proxy after");
	}
}
