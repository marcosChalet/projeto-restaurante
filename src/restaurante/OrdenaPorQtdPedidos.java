package restaurante;

import java.util.Comparator;

public class OrdenaPorQtdPedidos implements Comparator<Pessoas>{
	public int compare(Pessoas a, Pessoas b) {
		return b.getPedidos().size() - a.getPedidos().size();
	}
}
