package cz.fi.muni.pa165.entity;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import cz.fi.muni.pa165.enums.Color;

@Entity
public class Product {
        @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Column(nullable=true,unique=true)
	private String name;
        
        @Enumerated(EnumType.STRING)
        public Color color;
        
        @Temporal(TemporalType.DATE)
        public Date addedDate;
        
        public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
        public Long getId() {
		return id;
	}

        public void setId(Long id) {
            this.id = id;
        }
       
        public void setAddedDate(Date addedDate) {
            this.addedDate = addedDate;
        }
        
        public Date getAddedDate() {
            return addedDate;
        }
        
        public Color getColor() {
            return color;
        }
        
        public void setColor(Color color) {
            this.color = color;
        }      	
        
        @Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (! (obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (!name.equals(other.getName()))
			return false;
		return true;
	}
	
}
