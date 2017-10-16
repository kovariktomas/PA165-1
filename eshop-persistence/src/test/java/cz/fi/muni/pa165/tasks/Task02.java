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
                
                category1 = new Category();
		category1.setName("Electro");
                category1.addProduct(product1);
		em1.persist(category1);
                
               
                category2= new Category();
		category2.setName("Kitchen");
                category2.addProduct(product2);
                category2.addProduct(product3);
		em1.persist(category2);
                
                product1 = new Product();
                product1.setName("Flashlight");
                product1.addCategory(category1);
                em1.persist(product1);
                product2 = new Product();
                product2.setName("Kitchen robot");
                product2.addCategory(category2);
                em1.persist(product2);
                product3 = new Product();
                product3.setName("Plate");
                product3.addCategory(category2);
                em1.persist(product3);
		em1.getTransaction().commit();
		em1.close();
                
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
               
                Assert.assertEquals(c1.getName(), category1.getName());
                this.assertContainsProductWithName(c1.getProducts(), "Flashlight");           
		em_task01.close();
	}
        
        
        @Test
	public void category2Test() {
		
                EntityManager em_task01 = emf.createEntityManager();
		em_task01.getTransaction().begin();
		
                Category c2 = em_task01.find(Category.class, category2.getId());
               
                Assert.assertEquals(c2.getName(), category2.getName());
                this.assertContainsProductWithName(c2.getProducts(), "Kitchen robot");  
                 this.assertContainsProductWithName(c2.getProducts(), "Plate");  
		em_task01.close();
	}
        
        
        @Test
	public void product1Test() {
		
                EntityManager em_task01 = emf.createEntityManager();
		em_task01.getTransaction().begin();
		
                Product p1 = em_task01.find(Product.class, product1.getId());
               
                Assert.assertEquals(p1.getName(), product1.getName());
                this.assertContainsCategoryWithName(p1.getCategories(), "Electro");  
              
		em_task01.close();
	}
        
         @Test
	public void product2Test() {
		
                EntityManager em_task01 = emf.createEntityManager();
		em_task01.getTransaction().begin();
		
                Product p2 = em_task01.find(Product.class, product2.getId());
               
                Assert.assertEquals(p2.getName(), product2.getName());
                this.assertContainsCategoryWithName(p2.getCategories(), "Kitchen");  
              
		em_task01.close();
	}
        
         @Test
	public void product3Test() {
		
                EntityManager em_task01 = emf.createEntityManager();
		em_task01.getTransaction().begin();
		
                Product p3 = em_task01.find(Product.class, product3.getId());
               
                Assert.assertEquals(p3.getName(), product3.getName());
                this.assertContainsCategoryWithName(p3.getCategories(), "Kitchen");  
              
		em_task01.close();
	}

	
}
