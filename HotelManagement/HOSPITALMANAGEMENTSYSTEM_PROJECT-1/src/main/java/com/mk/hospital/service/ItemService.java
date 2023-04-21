package com.mk.hospital.service;

import java.util.List;

import com.mk.hospital.DAOimp.itemDAOImp;
import com.mk.hospital.dto.Item;

public class ItemService {
	public void saveItem(int mid,Item item)
	{
	    itemDAOImp daoImp=new itemDAOImp();
		Item item1=daoImp.SaveItemByid(mid, item);
		if(item1!=null)
		{
			System.out.println("Items Saved");
		}
		else
		{
			System.out.println("Unfortunately data not found");
		}
	}
	public Item getItemById(int id)
	{
		itemDAOImp daoImpl=new itemDAOImp();
		Item item=daoImpl.getItemById(id);
		if(item!=null)
		{
			return item;
		}
		else
		{
			return null;
		}
	}
	public void deleItemById(int id)
	{
		itemDAOImp daoImpl=new itemDAOImp();
		boolean flag=daoImpl.deletetemById(id);
		if(flag)
		{
			System.out.println("Items Deleted");
		}
		else
		{
			System.out.println("Items Not Deleted");
		}
	}
	public Item updateItemByid(int id,Item item)
	{
		itemDAOImp daoImpl=new itemDAOImp();
		Item item1=daoImpl.updateItemById(id);
		if(item1!=null)
		{
			return item1;
		}
		else
		{
			return null;
		}
	}
	public List<Item> getAllItem()
	{
		itemDAOImp daoImpl=new itemDAOImp();
		List<Item> item=daoImpl.getAllItem();
		return item;
	}


}
