package com.todolist.springvue.model;

import lombok.*;  

import javax.persistence.Id;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Entity;  
  
@Entity  
@Data  
@NoArgsConstructor  
public class Todo {  
      
  @Id @GeneratedValue  
  private Long id;  
  
  private Boolean terminado = false;

  @NonNull
  private String nome;  

  public Long getId() {
	return id;
  }

  public void setId(Long id) {
	this.id = id;
  }

  public Boolean getTerminado() {
	return terminado;
  }

  public void setTerminado(Boolean terminado) {
	this.terminado = terminado;
  }

  public void setNome(String nome) {
	this.nome = nome;
  }
  
  public String getNome(){
	  return this.nome;
  }
      
}
