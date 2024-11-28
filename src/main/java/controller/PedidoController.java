package controller;


import entity.Pedido;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Pedidos", description = "Recurso para criar um novo pedido")
@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {

    private final Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @Operation(
            summary = "Cria um novo pedido",
            description = "Cria um novo pedido no sistema",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Pedido criado com sucesso",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Pedido.class))),
                    @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
            }
    )

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
