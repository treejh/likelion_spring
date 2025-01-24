package aop.exam.proxy;

public class ProxyService implements Service{
    private RealService realService;

    @Override
    public void perform() {
        if(realService==null){
            realService = new RealService();
        }

        System.out.println("추가로 해야하는 작업 수행");
        realService.perform();

        System.out.println("aop가 구현한 코드라든지,, 추가로 수행 해야하는 작업들을 수행 ");
    }
}
