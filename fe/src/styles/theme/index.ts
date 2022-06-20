import { DefaultTheme } from 'styled-components';

import { colors } from './color';
import { fonts } from './font';
import { iconSizes } from './icon';

export type ColorsTypes = typeof colors;
export type FontTypes = typeof fonts;
export type IconSizeTypes = typeof iconSizes;

export const theme: DefaultTheme = {
  colors,
  fonts,
  iconSizes,
};
