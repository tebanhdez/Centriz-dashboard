package cr.centriz.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NoContentException;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import cr.centriz.entities.Brand;
import cr.centriz.utils.BrandObjectData;

public class BrandService {
    private static final Log LOGGER = LogFactory.getLog(BrandService.class);

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("centrizManager");
    EntityManager em = emf.createEntityManager();

    public Response createBrand(BrandObjectData objectData) {
        Brand brand = new Brand();
        brand.setName(objectData.getName());
        try {
            em.getTransaction().begin();
            em.persist(brand);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.ok("{\"msg \": \"Brand created correctly\"}", MediaType.APPLICATION_JSON).build();
    }

    private Brand getBrandById(int id) {
        em.getTransaction().begin();
        Brand brand = em.find(Brand.class, id);
        em.getTransaction().commit();
        return brand;
    }

    public BrandObjectData getSimplifiedBrandById(int id) throws NoContentException {
        Brand brand = getBrandById(id);
        if (brand == null) {
            LOGGER.error("Brand not found");
            throw new NoContentException("\"Error \": \"Brand not found\"");
        }
        BrandObjectData brandObjectData = new BrandObjectData();
        brandObjectData.setName(brand.getName());
        return brandObjectData;
    }

    public Response updateBrand(BrandObjectData objectData) {
        Brand brand = new Brand();
        brand.setName(objectData.getName());
        try {
            em.getTransaction().begin();
            em.persist(brand);
            em.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return Response.ok("{\"msg \": \"Brand updated correctly\"}", MediaType.APPLICATION_JSON).build();
    }

    public Response deleteBrandById(int id) {
        Brand brand = getBrandById(id);
        em.getTransaction().begin();
        em.remove(brand);
        em.getTransaction().commit();
        return Response.ok("{\"msg \": \"Brand deleted correctly\"}", MediaType.APPLICATION_JSON).build();
    }
}