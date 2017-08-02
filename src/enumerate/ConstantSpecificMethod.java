package enumerate;

import com.sun.corba.se.impl.orbutil.closure.Constant;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

import java.util.*;
import java.text.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public enum ConstantSpecificMethod {
    DATE_TME {
        public String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH {
        public String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    VERSON {
        public String getInfo() {
            return System.getProperty("java.version");
        }
    };
    abstract String getInfo();
    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : ConstantSpecificMethod.values()) {
            System.out.println(csm.getInfo());
        }
    }
}
