package com.health.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduct;
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 3, max = 150, message = "El nombre debe tener entre 3 y 150 caracteres")
    @Column(length = 150, nullable = false)
    private String name;
    
    @Size(max = 250, message = "La descripción no puede exceder 250 caracteres")
    @Column(length = 250)
    private String description;
    
    @Future(message = "La fecha de vencimiento debe ser futura")
    @Column(nullable = false)
    private LocalDate expired;
    
    @Size(max = 100, message = "La presentación no puede exceder 100 caracteres")
    @Column(length = 100)
    private String presentation;
    
    @NotNull(message = "El stock es requerido")
    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(nullable = false)
    private Integer stock;
    
    @NotNull(message = "El precio unitario es requerido")
    @DecimalMin(value = "0.01", message = "El precio debe ser mayor a 0")
    @Column(name = "unit_price", nullable = false)
    private Double unitPrice;
    
    @NotNull(message = "La categoría es requerida")
    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false, foreignKey = @ForeignKey(name = "FK_product_category"))
    private Category category;
    
    @NotNull(message = "La familia es requerida")
    @ManyToOne
    @JoinColumn(name = "id_family", nullable = false, foreignKey = @ForeignKey(name = "FK_product_family"))
    private Family family;
    
    @NotNull(message = "El laboratorio es requerido")
    @ManyToOne
    @JoinColumn(name = "id_laboratory", nullable = false, foreignKey = @ForeignKey(name = "FK_product_laboratory"))
    private Laboratory laboratory;

    // --- Getters y Setters ---
    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpired() {
        return expired;
    }

    public void setExpired(LocalDate expired) {
        this.expired = expired;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }
}
