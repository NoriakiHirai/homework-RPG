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
            //�t�@�C����ǂݍ���
            FileReader fr = new FileReader("C:\\Users\\nhirai\\eclipse-workspace\\javase\\8.141\\homework-RPG\\src\\rpg\\items\\weapons\\WeaponList.csv");
            BufferedReader br = new BufferedReader(fr);

            //�ǂݍ��񂾃t�@�C�����P�s����������
            String line;
            while ((line = br.readLine()) != null) {
                //��؂蕶��","�ŕ�������
            	String[] weaponInfo = line.split(",");
            	//����������������}�b�v�Ɋi�[����
                weapons.put(weaponInfo[0], weaponInfo[1]); 
            }

            //�I������
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
            //�t�@�C����ǂݍ���
            FileReader fr = new FileReader("C:\\Users\\nhirai\\eclipse-workspace\\javase\\8.141\\homework-RPG\\src\\rpg\\items\\armors\\ArmorList.csv");
            BufferedReader br = new BufferedReader(fr);

            //�ǂݍ��񂾃t�@�C�����P�s����������
            String line;
            while ((line = br.readLine()) != null) {
                //��؂蕶��","�ŕ�������
            	String[] armorInfo = line.split(",");
            	//����������������}�b�v�Ɋi�[����
            	armors.put(armorInfo[0], armorInfo[1]); 
            }

            //�I������
            br.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return armors;
        
	}

}
