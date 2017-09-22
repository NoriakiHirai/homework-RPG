package rpg.items.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class ItemUtility {
	
	public static HashMap<String, String> getWeapons() {
		HashMap<String,String> weapons = new HashMap<String,String>();
        try {
            //ファイルを読み込む
            FileReader fr = new FileReader("C:\\Users\\nhirai\\eclipse-workspace\\javase\\8.141\\homework-RPG\\src\\rpg\\items\\weapons\\WeaponList.csv");
            BufferedReader br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ処理する
            String line;
            while ((line = br.readLine()) != null) {
                //区切り文字","で分割する
            	String[] weaponInfo = line.split(",");
            	//分割した文字列をマップに格納する
                weapons.put(weaponInfo[0], weaponInfo[1]); 
            }

            //終了処理
            br.close();
           
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        }

        return weapons;
        
	}

	public static HashMap<String, String> getArmors() {
		HashMap<String,String> armors = new HashMap<String,String>();
        try {
            //ファイルを読み込む
            FileReader fr = new FileReader("C:\\Users\\nhirai\\eclipse-workspace\\javase\\8.141\\homework-RPG\\src\\rpg\\items\\armors\\ArmorList.csv");
            BufferedReader br = new BufferedReader(fr);

            //読み込んだファイルを１行ずつ処理する
            String line;
            while ((line = br.readLine()) != null) {
                //区切り文字","で分割する
            	String[] armorInfo = line.split(",");
            	//分割した文字列をマップに格納する
            	armors.put(armorInfo[0], armorInfo[1]); 
            }

            //終了処理
            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return armors;
        
	}

}
