package catking.bean;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CartBean {
	private Map<Integer, ItemBean> items = new HashMap<Integer, ItemBean>();
	private int total;

	public Map<Integer, ItemBean> getItems() {
		return items;
	}

	public void addCart(ItemBean bean, int nums) {
		ItemBean item = (ItemBean) items.get(new Integer(bean.getId()));
		if (item == null) {
			bean.setQty(nums);
			items.put(new Integer(bean.getId()), bean);
		} else {
			item.setQty(nums + item.getQty());
		}
		recalcTotal();
	}

	public void deleteCart(int itemId) {
		items.remove(new Integer(itemId));
		recalcTotal();
	}

	public int getTotal() {
		return total;
	}

	private void recalcTotal() {
		total = 0;
		Collection<ItemBean> list = items.values();
		for (ItemBean item : list) {
			total += item.getPrice() * item.getQty();
		}
	}
}