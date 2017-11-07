package rpg;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LogFactory {
	
	static Handler handler;
	
	static {
		try {
			handler = new FileHandler("C:/Data/log/java/homework-rpg/debug.log", true);
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// フォーマッターを作成してハンドラーに登録
		Formatter formatter =  new SimpleFormatter();
		handler.setFormatter(formatter);
	}
	
	private LogFactory() {
		super();
	}

	public static Logger createLogger(String loggerName) {
		// ロガーを取得してログレベルをFINEに設定（開発完了後は、レベルを上げること）
		Logger logger = Logger.getLogger(loggerName);
		logger.setLevel(Level.FINE);
		// ハンドラーをロガーに登録
		logger.addHandler(handler);
		return logger;
	}
	
}
