package net.pruebatecnica.test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import net.pruebatecnica.dao.ProveedorDAO;
import net.pruebatecnica.model.Proveedor;

@ExtendWith(MockitoExtension.class)
class ProveedorDAOTest {

    private ProveedorDAO proveedorDAO;

    @BeforeEach
    public void setUp() {
        proveedorDAO = new ProveedorDAO();
    }

    @Test
    public void testSelectAllProveedores() {
        List<Proveedor> proveedores = proveedorDAO.selectAllProveedores();

        assertNotNull(proveedores, "La lista de proveedores no debe ser nula");
        assertTrue(proveedores.size() == 6, "Debe recoger los 6 registros de la base de datos");

        Proveedor p = proveedores.get(0);
        assertEquals("Coca-cola",p.getNombre());
        System.out.println("Primer proveedor: " + p.getNombre());
    }

    @Test
    public void testSelectProveedoresByIdCliente() {
        int idCliente = 5; 
        List<Proveedor> proveedores = proveedorDAO.selectProveedoresByIdCliente(idCliente);

        assertNotNull(proveedores, "La lista de proveedores no debe ser nula");
        assertTrue(proveedores.size() == 2, "Existen dos registros con este idCliente en la base de datos");
        
        for (Proveedor p : proveedores) {
            assertEquals(idCliente, p.getIdCliente(), "El idCliente debe coincidir");
        }
    }
    
    @Test
    public void testSelectProveedoresByIdClienteVacia() {
        int idCliente = 9; 
        List<Proveedor> proveedores = proveedorDAO.selectProveedoresByIdCliente(idCliente);

        assertNotNull(proveedores, "La lista de proveedores no debe ser nula");
        assertTrue(proveedores.size() == 0, "No existen registros con este idCliente en la base de datos");       
        
    }

}
