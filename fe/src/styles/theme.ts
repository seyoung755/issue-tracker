import { DefaultTheme } from 'styled-components';

const color = {};

const fontSize = {};

const fontWeight = {};

export type ColorTypes = typeof color;
export type FontSizeTypes = typeof fontSize;
export type FontWeightTypes = typeof fontWeight;

export const theme: DefaultTheme = {
  color,
  fontSize,
  fontWeight,
};
