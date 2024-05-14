package tr.edu.mediol.ortamaraclari.springbootwebservicedemo;

import java.util.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ogrenci")
public class OgrenciWebServisi 
{
	public record Ogrenci(String numara, String name) {}
	
	private static List<Ogrenci> OGRENCILER = new ArrayList<>();
	static {
		OGRENCILER.add(new Ogrenci("1","Ali"));
		OGRENCILER.add(new Ogrenci("2","Veli"));
		}
	
	
	@GetMapping("/")
	public List<Ogrenci> listele()
	{
		return OGRENCILER;
	}
	
	@PostMapping("/")
	public void ekle(Ogrenci ogr) {
		OGRENCILER.add(ogr);
	}
	
	
	@DeleteMapping("/{numara}")
	public boolean sil(@PathVariable("numara") String numara) {
		
		for(Ogrenci ogrenci: OGRENCILER) {
			if(ogrenci.numara.equals(numara)) {
				OGRENCILER.remove(ogrenci);
				return true;
			}
		}
		return false;
	}
	
}
