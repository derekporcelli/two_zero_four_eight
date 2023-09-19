package com.derekporcelli.two_zero_four_eight;

import javafx.scene.paint.Color;

public class ColorMapping
    {
        public static Color getColor (int value)
            {
                switch (value)
                    {
                        case 2:
                            return Color.rgb(238, 228, 218);
                        case 4:
                            return Color.rgb(237, 224, 200);
                        case 8:
                            return Color.rgb(242, 177, 121);
                        case 16:
                            return Color.rgb(245, 149, 99);
                        case 32:
                            return Color.rgb(246, 124, 95);
                        case 64:
                            return Color.rgb(246, 94, 59);
                        case 128:
                            return Color.rgb(237, 207, 114);
                        case 256:
                            return Color.rgb(237, 204, 97);
                        case 512:
                            return Color.rgb(237, 200, 80);
                        case 1024:
                            return Color.rgb(237, 197, 63);
                        case 2048:
                            return Color.rgb(237, 194, 46);
                        default:
                            return Color.rgb(238, 238, 228);
                    }
            }
    }
