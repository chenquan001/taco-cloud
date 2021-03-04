package tacos.data;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import tacos.Order;
import tacos.Taco;
@Repository
public class JdbcOrderRepository implements OrderRepository {

    private SimpleJdbcInsert orderInsert;
    private SimpleJdbcInsert orderTacoInsert;
    private ObjectMapper objectMapper;

    public JdbcOrderRepository(JdbcTemplate jdbcTemplate){
        this.orderInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Taco_Order")
                .usingGeneratedKeyColumns("id");
        
        this.orderTacoInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Taco_Order_Tacos");

        this.objectMapper = new ObjectMapper();
    }

    @Override
    public Order save(Order order) {
        order.setPlacedAt(new Date());
        Long orderId = saveOrderInfo(order);
        order.setId(orderId);
        for(Taco taco : order.getTacos()){
            saveTacoToOrder(taco, orderId);
        }

        return order;
    }

    private void saveTacoToOrder(Taco taco, Long orderId) {
        Map<String, Object> values = new HashMap<>(10);
        values.put("tacoOrder", orderId);
        values.put("taco", taco.getId());
        orderTacoInsert.execute(values);
    }

    private Long saveOrderInfo(Order order) {
        Map<String, Object> values =  objectMapper.convertValue(order, Map.class);
        values.put("placedAt", order.getPlacedAt());
        return orderInsert.executeAndReturnKey(values).longValue();
    }

}