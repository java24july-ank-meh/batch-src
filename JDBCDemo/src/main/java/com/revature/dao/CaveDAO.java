package com.revature.dao;

import java.util.List;

import com.revature.domain.Cave;

public interface CaveDAO {
	
	public void createCave(Cave c);
	public void readCave(int id);
	public List<Cave> readAllCaves();
	public void updateCave(Cave c);
	public void deleteCave(int id);
	
	public void feedBear(int bid, int amt);

}
