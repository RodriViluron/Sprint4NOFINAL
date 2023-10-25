package com.Spring3Pimienta.Spring4;

import com.Spring3Pimienta.Spring4.entities.*;
import com.Spring3Pimienta.Spring4.enums.EstadoPedido;
import com.Spring3Pimienta.Spring4.enums.FormaPago;
import com.Spring3Pimienta.Spring4.enums.Rol;
import com.Spring3Pimienta.Spring4.enums.TipoEnvio;
import com.Spring3Pimienta.Spring4.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Spring3Application {
	@Autowired
	RubroProductoRepository rubroProductoRepository;
	@Autowired
	IngredienteRepository ingredienteRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DetalleProductoRepository detalleProductoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroIngredienteRepository rubroIngrdienteRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(Spring3Application.class, args);
		System.out.println("Estoy funcionando");
	}

	@Bean //HACER modificaciones cuando hagan los cambios en el modelo de clases
	public CommandLineRunner init(RubroProductoRepository categoriaProductoRepo, IngredienteRepository ingredienteRepo, ProductoRepository productoRepo,
								  ClienteRepository clienteRepo, DetalleProductoRepository detalleProductoRepo,
								  DetalleFacturaRepository detalleFacturaRepo, DetallePedidoRepository detallePedidoRepo,
								  DomicilioRepository domicilioRepo, FacturaRepository facturaRepo, PedidoRepository pedidoRepo,
								  RubroIngredienteRepository rubroIngredienteRepo, UnidadMedidaRepository unidadMedidaRepo,
								  UsuarioRepository usuarioRepo) {
		System.out.println("-----------------ESTOY FUNCIONANDO---------");
		return args -> {

			//-----------------------------------------------
			//				Rehacerlo mas bonito
			//-----------------------------------------------

			//Le doy formato a Date
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fecha1 = "2023-09-10";
			String fecha2 = "2023-08-15";
			String fecha3 = "2023-07-03";

			//Parseo String en un objeto Date
			Date fechaUno = formatoFecha.parse(fecha1);
			Date fechaDos = formatoFecha.parse(fecha2);
			Date fechaTres = formatoFecha.parse(fecha3);

			//Formato Date para horaEstimadaFinalizacion
			SimpleDateFormat formatoHorario = new SimpleDateFormat("HH:mm:ss");
			String horario1 = "21:42:05";
			String horario2 = "23:00:58";
			String horario3 = "23:28:32";

			//Parseo String en un objeto Date
			Date horarioUno = formatoFecha.parse(fecha1);
			Date horarioDos = formatoFecha.parse(fecha2);
			Date horarioTres = formatoFecha.parse(fecha3);

			// Crear Clientes
			Cliente cliente1 = Cliente.builder()
					.nombre("Rodrigo")
					.apellido("Viluron")
					.telefono("2617869567")
					.email("rodri@gmail.com")
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Roberto")
					.apellido("Marin")
					.telefono("764467375")
					.email("roberto@gmail.com")
					.build();


			// Crear Domicilios
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle falsa")
					.numeroDomicilio(123)
					.codigoPostal(5507)
					.localidad("Luján de Cuyo")
					.numeroDpto(1)
					.pisoDpto(1)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Callejón falso")
					.numeroDomicilio(456)
					.codigoPostal(5501)
					.localidad("Godoy Cruz")
					.build();

			Domicilio domicilio3 = Domicilio.builder()
					.calle("Callejón Rodriguez")
					.numeroDomicilio(1864)
					.codigoPostal(5525)
					.localidad("Las Heras")
					.build();

			// Asignar Domicilio a Cliente
			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio3);
			cliente2.agregarDomicilio(domicilio2);




			// Crear Usuario
			Usuario usuario1 = Usuario.builder()
					.auth0Id("1")
					.username("rodri@gmail.com")
					.rol(Rol.CLIENTE)
					.build();


			Usuario usuario2 = Usuario.builder()
					.auth0Id("2")
					.username("roberto@gmail.com")
					.rol(Rol.CLIENTE)
					.build();


			// Agregar usuarios a los clientes
			cliente1.setUsuario(usuario1);
			cliente2.setUsuario(usuario2);

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);



			// Crear Rubro
			RubroIngrediente rubro1 = RubroIngrediente.builder()
					.denominacion("vegetales")
					.build();

			RubroIngrediente rubro2 = RubroIngrediente.builder()
					.denominacion("Carnes")
					.build();

			RubroIngrediente rubro3 = RubroIngrediente.builder()
					.denominacion("Panes")
					.build();

			RubroIngrediente rubro4 = RubroIngrediente.builder()
					.denominacion("Fiambres")
					.build();

			// Crear Ingredientes
			Ingrediente ingrediente1 = Ingrediente.builder()
					.denominacion("tomate")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenTomate")
					.build();

			Ingrediente ingrediente2 = Ingrediente.builder()
					.denominacion("lechuga")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenlechuga")
					.build();

			Ingrediente ingrediente3 = Ingrediente.builder()
					.denominacion("cebolla")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenCebolla")
					.build();

			Ingrediente ingrediente4 = Ingrediente.builder()
					.denominacion("carne de hamburgesa")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenCarne")
					.build();

			Ingrediente ingrediente5 = Ingrediente.builder()
					.denominacion("carne de lomo")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenLomo")
					.build();

			Ingrediente ingrediente6 = Ingrediente.builder()
					.denominacion("pan de hamburgesa clasico")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenPanHamburgesaClasico")
					.build();

			Ingrediente ingrediente7 = Ingrediente.builder()
					.denominacion("queso")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenQueso")
					.build();

			Ingrediente ingrediente8 = Ingrediente.builder()
					.denominacion("jamon")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenJamon")
					.build();

			Ingrediente ingrediente9 = Ingrediente.builder()
					.denominacion("pan de lomo clasico")
					.stockActual(50.20)
					.stockMinimo(10.0)
					.precioCompra(5)
					.urlImagen("urlImagenPanLomoClasico")
					.build();

			// Crear UnidadMedida
			UnidadMedida unidadMedida1 = UnidadMedida.builder()
					.denominacion("gramos")
					.abreviatura("gr")
					.build();

			// Asignar UnidadMedida a Ingrediente
			ingrediente1.setUnidadMedida(unidadMedida1);
			ingrediente2.setUnidadMedida(unidadMedida1);
			ingrediente3.setUnidadMedida(unidadMedida1);
			ingrediente4.setUnidadMedida(unidadMedida1);
			ingrediente5.setUnidadMedida(unidadMedida1);
			ingrediente6.setUnidadMedida(unidadMedida1);
			ingrediente7.setUnidadMedida(unidadMedida1);
			ingrediente8.setUnidadMedida(unidadMedida1);
			ingrediente9.setUnidadMedida(unidadMedida1);

			// Asignar Ingrediente a Rubro
			rubro1.agregarIngrediente(ingrediente1);
			rubro1.agregarIngrediente(ingrediente2);
			rubro1.agregarIngrediente(ingrediente3);
			rubro2.agregarIngrediente(ingrediente4);
			rubro2.agregarIngrediente(ingrediente5);
			rubro3.agregarIngrediente(ingrediente6);
			rubro4.agregarIngrediente(ingrediente7);
			rubro4.agregarIngrediente(ingrediente8);
			rubro3.agregarIngrediente(ingrediente9);

			//Guardar Rubros con ingredientes y unidad de medida
			rubroIngredienteRepo.save(rubro1);
			rubroIngredienteRepo.save(rubro2);
			rubroIngredienteRepo.save(rubro3);
			rubroIngredienteRepo.save(rubro4);


			// Crear Categoría de Productos
			RubroProducto rubroProducto1 = RubroProducto.builder()
					.denominacion("Hamburguesas")
					.build();

			RubroProducto rubroProducto2 = RubroProducto.builder()
					.denominacion("Lomos")
					.build();



			// Crear Productos
			Producto producto1 = Producto.builder()
					.denominacion("Hamburguesa_clásica")
					.descripcion("Carne, pan, lechuga, tomate, queso.")
					.tiempoEstimadoCocina(20)
					.precioVenta(4000.00)
					.precioCosto(1500.00)
					.urlImagen("urlImagenHamburguesaClásica")
					.build();

			Producto producto2 = Producto.builder()
					.denominacion("Lomo_clásico")
					.descripcion("Cocinado a la parrilla y sazonado al gusto, con lechuga, tomate y cebolla.")
					.tiempoEstimadoCocina(25)
					.precioVenta(4500.00)
					.precioCosto(2000.00)
					.urlImagen("urlImagenLomoClásico")
					.build();

			// Asignar Producto a Categoría de Productos
			rubroProducto1.agregarProducto(producto1);
			rubroProducto2.agregarProducto(producto2);


			// Crear DetalleProducto
			//Producto 1
			DetalleProducto detalleProducto11 = DetalleProducto.builder()
					.cantidad(30)
					.ingrediente(ingrediente1)
					.build();

			DetalleProducto detalleProducto12 = DetalleProducto.builder()
					.cantidad(30)
					.ingrediente(ingrediente2)
					.build();

			DetalleProducto detalleProducto13 = DetalleProducto.builder()
					.cantidad(50)
					.ingrediente(ingrediente7)
					.build();

			DetalleProducto detalleProducto14 = DetalleProducto.builder()
					.cantidad(200)
					.ingrediente(ingrediente4)
					.build();

			DetalleProducto detalleProducto15 = DetalleProducto.builder()
					.cantidad(100)
					.ingrediente(ingrediente6)
					.build();

			//Producto 2
			DetalleProducto detalleProducto21 = DetalleProducto.builder()
					.cantidad(30)
					.ingrediente(ingrediente1)
					.build();

			DetalleProducto detalleProducto22 = DetalleProducto.builder()
					.cantidad(30)
					.ingrediente(ingrediente2)
					.build();

			DetalleProducto detalleProducto23 = DetalleProducto.builder()
					.cantidad(30)
					.ingrediente(ingrediente3)
					.build();

			DetalleProducto detalleProducto24 = DetalleProducto.builder()
					.cantidad(300)
					.ingrediente(ingrediente5)
					.build();

			DetalleProducto detalleProducto25 = DetalleProducto.builder()
					.cantidad(200)
					.ingrediente(ingrediente9)
					.build();

			// Asignar DetalleProducto a Producto
			producto1.agregarDetalleProducto(detalleProducto11);
			producto1.agregarDetalleProducto(detalleProducto12);
			producto1.agregarDetalleProducto(detalleProducto13);
			producto1.agregarDetalleProducto(detalleProducto14);
			producto1.agregarDetalleProducto(detalleProducto15);

			producto2.agregarDetalleProducto(detalleProducto21);
			producto2.agregarDetalleProducto(detalleProducto22);
			producto2.agregarDetalleProducto(detalleProducto23);
			producto2.agregarDetalleProducto(detalleProducto24);
			producto2.agregarDetalleProducto(detalleProducto25);


			// Guardar rubro producto con los productos y detalles producto
			rubroProductoRepository.save(rubroProducto1);
			rubroProductoRepository.save(rubroProducto2);

			// Crear Pedido
			Pedido pedido1 = Pedido.builder()
					.fechaPedido(fechaUno)
					.horaEstimadaFinalizacion(horarioUno)
					.totalPedido(8500)
					.estadoPedido(EstadoPedido.EN_COCINA)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.formaPago(FormaPago.EFECTIVO)
					.cliente(cliente1)
					.domicilioEntrega(domicilio1)
					.build();

			Pedido pedido2 = Pedido.builder()
					.fechaPedido(fechaDos)
					.horaEstimadaFinalizacion(horarioDos)
					.totalPedido(8500)
					.estadoPedido(EstadoPedido.ENTREGADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.formaPago(FormaPago.MERCADO_PAGO)
					.cliente(cliente2)
					.domicilioEntrega(domicilio2)
					.build();

			Pedido pedido3 = Pedido.builder()
					.fechaPedido(fechaDos)
					.horaEstimadaFinalizacion(horarioDos)
					.totalPedido(8500)
					.estadoPedido(EstadoPedido.A_CONFIRMAR)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.formaPago(FormaPago.EFECTIVO)
					.cliente(cliente1)
					.domicilioEntrega(domicilio3)
					.build();

			//crear Detalle Pedido

			DetallePedido detallePedido11=DetallePedido.builder()
					.cantidad(1)
					.subtotal(4000)
					.producto(producto1)
					.build();

			DetallePedido detallePedido12=DetallePedido.builder()
					.cantidad(2)
					.subtotal(2250)
					.producto(producto2)
					.build();

			DetallePedido detallePedido21=DetallePedido.builder()
					.cantidad(3)
					.subtotal(8600)
					.producto(producto1)
					.build();

			DetallePedido detallePedido22=DetallePedido.builder()
					.cantidad(2)
					.subtotal(4500)
					.producto(producto2)
					.build();

			DetallePedido detallePedido31=DetallePedido.builder()
					.cantidad(3)
					.subtotal(2100)
					.producto(producto2)
					.build();

			DetallePedido detallePedido32=DetallePedido.builder()
					.cantidad(1)
					.subtotal(4000)
					.producto(producto2)
					.build();

			//agregamos los detalles al pedido
			pedido1.agregarDetallePedido(detallePedido11);
			pedido1.agregarDetallePedido(detallePedido12);
			pedido2.agregarDetallePedido(detallePedido21);
			pedido2.agregarDetallePedido(detallePedido22);
			pedido3.agregarDetallePedido(detallePedido31);
			pedido3.agregarDetallePedido(detallePedido32);

			// Crear Factura
			Factura factura1 = Factura.builder()
					.fechaFacturacion(fechaUno)
					.numeroFactura(1)
					.porcentajeDescuento(10.00)
					.formaPago(FormaPago.EFECTIVO)
					.totalCosto(3000.00)
					.totalVenta(8500.00)
					.build();

			Factura factura2 = Factura.builder()
					.fechaFacturacion(fechaUno)
					.numeroFactura(2)
					.porcentajeDescuento(0.0)
					.formaPago(FormaPago.MERCADO_PAGO)
					.totalCosto(4000.00)
					.totalVenta(9500.00)
					.build();

			Factura factura3 = Factura.builder()
					.fechaFacturacion(fechaUno)
					.numeroFactura(3)
					.porcentajeDescuento(10.00)
					.formaPago(FormaPago.EFECTIVO)
					.totalCosto(4000.00)
					.totalVenta(6100.00)
					.build();

			//crear detalleFactura

			DetalleFactura detalleFactura11=DetalleFactura.builder()
					.cantidad(1)
					.subtotal(4000)
					.producto(producto1)
					.build();

			DetalleFactura detalleFactura12=DetalleFactura.builder()
					.cantidad(2)
					.subtotal(2250)
					.producto(producto2)
					.build();

			DetalleFactura detalleFactura21=DetalleFactura.builder()
					.cantidad(3)
					.subtotal(8600)
					.producto(producto1)
					.build();

			DetalleFactura detalleFactura22=DetalleFactura.builder()
					.cantidad(2)
					.subtotal(4500)
					.producto(producto2)
					.build();

			DetalleFactura detalleFactura31=DetalleFactura.builder()
					.cantidad(3)
					.subtotal(2100)
					.producto(producto2)
					.build();

			DetalleFactura detalleFactura32=DetalleFactura.builder()
					.cantidad(1)
					.subtotal(4000)
					.producto(producto2)
					.build();

			//Agreagamos los detalle factura a la factura

			factura1.agregarDetalleFactura(detalleFactura11);
			factura1.agregarDetalleFactura(detalleFactura12);
			factura2.agregarDetalleFactura(detalleFactura21);
			factura2.agregarDetalleFactura(detalleFactura22);
			factura3.agregarDetalleFactura(detalleFactura31);
			factura3.agregarDetalleFactura(detalleFactura32);

			// Asignar Factura a Pedido
			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);
			pedido3.setFactura(factura3);

			//Guardamos el pedido junto con el datalle del pedido y la factura con sus detalles
			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);
			pedidoRepository.save(pedido3);






			//-----------------------------------------------------------------------------------
			//Uso de Métodos

			//recuperar Cliente desde BD
			Cliente clienteRecuperado = clienteRepository.findById(cliente1.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Email: " + clienteRecuperado.getEmail());
				System.out.println("Teléfono: " + clienteRecuperado.getTelefono());
				clienteRecuperado.mostrarDomicilios();
				System.out.println("----------------------------------------");
			}

			Producto productoRecuperado = productoRepository.findById(producto1.getId()).orElse(null);
			if (productoRecuperado != null) {
				System.out.println("-------------------------------------------------------");
				System.out.println("Denominacion: " + productoRecuperado.getDenominacion());
				System.out.println("Tiempo Estimado Cocina: " + productoRecuperado.getTiempoEstimadoCocina());
				System.out.println("Precio Venta: " + productoRecuperado.getPrecioVenta());
				System.out.println("Precio Costo: " + productoRecuperado.getPrecioCosto());
				productoRecuperado.mostrarDetalleProducto();
			}




		};

	}

}



