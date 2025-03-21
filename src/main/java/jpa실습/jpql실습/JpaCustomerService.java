package jpa실습.jpql실습;


import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class JpaCustomerService {
    private final JpaCustomerRepository jpaCustomerRepository;

    @Transactional
    public JpaCustomer getCustomer(Long id){
        // @Transactional을 사용하지 않으면, findByID 상황 에서 트랜잭션이 끝나기 떄문에
        // 원래 LAZY 상태라면 get할때 데이터를 받아야 하는데
        // findById에서 트래잭션이 이미 종료된 상태에서 LAZY Get을 사용하면 , 종료된 트랜잭션을 통해 데이터를 받아와달라고 부탁하는 것이다.
        // @Transactional을 사용해서 한 트랜잭션으로 만들어줘야 필요한 시점에 가져올 수 있따.
        JpaCustomer jpaCustomer = jpaCustomerRepository.findById(id).get();//원래라면 이때 트랜잭션 종료(conneciton종료)

        log.info("getCustomer getOrders 호출하는 시점 !!! ");
        List<JpaOrder> orderList = jpaCustomer.getOrderList();


        orderList.forEach(order -> log.info(order.getProduct()));

        return jpaCustomer;
    }

    @Transactional
    public List<Object[]> getCustomerCount(){
        return jpaCustomerRepository.findByCustomerOrderCount();
    }

}
