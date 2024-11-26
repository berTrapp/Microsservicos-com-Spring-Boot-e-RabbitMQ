package controller;


import entity.Pedido;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @PostMapping("/criarPedido")
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido){
        logger.info("Pedido recebido: {}", pedido.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedido);
    }

    @GetMapping("/oi")
    public String oi(){
        return "oi";
    }
}
