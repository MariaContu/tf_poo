//PRONTO

package poo.entities;

import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ImageFactory {
	private static ImageFactory imgf = new ImageFactory();
	private Map<String, Image> images;

	public static ImageFactory getInstance() {
		return imgf;
	}

	private ImageFactory() {
		images = new HashMap<>();
	}

	private String idImagem(String imgId) {
		switch (imgId) {
		case "1":
			return ("/images/1.png");
		case "2":
			return ("/images/2.png");
		case "3":
			return ("/images/3.png");
		case "4":
			return ("/images/4.png");
		case "5":
			return ("/images/5.png");
		case "6":
			return ("/images/6.png");
		case "7":
			return ("/images/7.png");
		case "8":
			return ("/images/8.png");
		case "9":
			return ("/images/9.png");
		case "10":
			return ("/images/10.png");
		case "11":
			return ("/images/11.png");
		case "12":
			return ("/images/12.png");
		case "13":
			return ("/images/13.png");
		case "14":
			return ("/images/14.png");
		case "15":
			return ("/images/15.png");
		case "16":
			return ("/images/16.png");
		case "17":
			return ("/images/17.png");
		case "18":
			return ("/images/18.png");
		case "19":
			return ("/images/19.png");
		case "20":
			return ("/images/20.png");
		case "21":
			return ("/images/21.png");
		case "22":
			return ("/images/22.png");
		case "23":
			return ("/images/23.png");
		case "24":
			return ("/images/24.png");
		case "25":
			return ("/images/25.png");
		case "26":
			return ("/images/26.png");
		case "27":
			return ("/images/27.png");
		case "28":
			return ("/images/28.png");
		case "29":
			return ("/images/29.png");
		case "30":
			return ("/images/30.png");
		case "31":
			return ("/images/31.png");
		case "32":
			return ("/images/32.png");
		case "33":
			return ("/images/33.png");
		case "34":
			return ("/images/34.png");
		case "Back":
			return ("/images/Back.png");
		default:
			throw new IllegalArgumentException("Invalid image Id");
		}
	}

	public ImageView criaImagem(String imgId) {
		Image img = images.get(imgId);
		if (img == null) {
			img = new Image(idImagem(imgId));
			images.put(imgId, img);
		}

		ImageView imgv = new ImageView(img);
		return imgv;
	}
}
