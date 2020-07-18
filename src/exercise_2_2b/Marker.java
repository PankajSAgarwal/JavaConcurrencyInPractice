package exercise_2_2b;

import java.io.Serializable;

/**
 * DO NOT CHANGE.
 * <p/>
 * This class is used to avoid checksum errors due to the special marker bytes
 * written out when ObjectOutputStream is created.
 */
public class Marker implements Serializable {
    private static final long serialVersionUID = -4855512266770971540L;
}
