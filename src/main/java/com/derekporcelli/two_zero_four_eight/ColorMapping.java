package com.derekporcelli.two_zero_four_eight;

import javafx.scene.paint.Color;

public class ColorMapping
    {
        public static final int startingValue = GameFX.startingValue;
        public static Color getColor (int value)
            {
                switch (value)
                    {
                        case startingValue:
                            return Color.rgb(238, 228, 218);
                        case startingValue * 2:
                            return Color.rgb(237, 224, 200);
                        case startingValue * 4:
                            return Color.rgb(242, 177, 121);
                        case startingValue * 8:
                            return Color.rgb(245, 149, 99);
                        case startingValue * 16:
                            return Color.rgb(246, 124, 95);
                        case startingValue * 32:
                            return Color.rgb(246, 94, 59);
                        case startingValue * 64:
                            return Color.rgb(237, 207, 114);
                        case startingValue * 128:
                            return Color.rgb(237, 204, 97);
                        case startingValue * 256:
                            return Color.rgb(237, 200, 80);
                        case startingValue * 512:
                            return Color.rgb(237, 197, 63);
                        case startingValue * 1024:
                            return Color.rgb(237, 194, 46);
                        default:
                            return Color.rgb(248, 248, 248);
                    }
            }
    }
