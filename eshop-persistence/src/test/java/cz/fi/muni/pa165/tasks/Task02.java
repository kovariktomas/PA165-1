package cz.fi.muni.pa165.tasks;

import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.validation.ConstraintViolationException;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cz.fi.muni.pa165.PersistenceSampleApplicationContext;
import cz.fi.muni.pa165.entity.Category;
import cz.fi.muni.pa165.entity.Product;
import java.util.HashSet;

 
@ContextConfiguration(classes = PersistenceSampleApplicationContext.class)
public class Task02 extends AbstractTestNGSpringContextTests {

	@PersistenceUnit
	private EntityManagerFactory emf;
        
        private Category category1, category2;
        private Product product1, product2, product3;
        
        
        @BeforeClass public void onlyOnce() {
                
                EntityManager em1 = emf.createEntityManager();
		em1.getTransaction().begin();
                product1 = new Product();
                product1.setName("Flashlight");
                //p1.addCategory(cat);
                em1.persist(product1);
                product2 = new Product();
                product2.setName("Kitchen robot");
                //p2.addCategory(cat1);
                em1.persist(product2);
                product3 = new Product();
                product3.setName("Plate");
                //p3.addCategory(cat1);
                em1.persist(product3);
		em1.getTransaction().commit();
		em1.close();
                
                EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		category1 = new Category();
		category1.setName("Electro");
                category1.addProduct(product1);
		em.persist(category1);
                
               
                category2= new Category();
		category2.setName("Kitchen");
                category2.addProduct(product2);
                category2.addProduct(product3);
		em.persist(category2);
                
                em.getTransaction().commit();
		em.close();
        }
	
       
	private void assertContainsCategoryWithName(Set<Category> categories,
			String expectedCategoryName) {
		for(Category cat: categories){
			if (cat.getName().equals(expectedCategoryName))
				return;
		}
			
		Assert.fail("Couldn't find category "+ expectedCategoryName+ " in collection "+categories);
	}
        
        
	private void assertContainsProductWithName(Set<Product> products,
			String expectedProductName) {
		
		for(Product prod: products){
			if (prod.getName().equals(expectedProductName))
				return;
		}
			
		Assert.fail("Couldn't find product "+ expectedProductName+ " in collection "+products);
	}
        
        @Test
	public void category1Test() {
		
                EntityManager em_task01 = emf.createEntityManager();
		em_task01.getTransaction().begin();
		
                Category c1 = em_task01.find(Category.class, category1.getId());
                
                //Assert.assertEquals(c1.getName(), category1.getName());
                this.assertContainsProductWithName(c1.getProducts(), "Flashlight");
                
                
		em_task01.close();
	}

	
}
