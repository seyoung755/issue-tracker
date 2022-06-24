export const FONT = {
  SIZE: {
    // html {font-size: 10px}
    X_SMALL: '1.2rem',
    SMALL: '1.4rem',
    BASE: '1.6rem',
    MEDIUM: '1.8rem',
    LARGE: '3.2rem',
    X_LARGE: '5.6rem',
  },
  WEIGHT: {
    REGULAR: '400',
    MEDIUM: '500',
    BOLD: '700',
  },
  FAMILY: {
    BASE: "'Noto Sans KR', sans-serif",
    LOGO: "'Montserrat', sans-serif",
  },
  STYLE: {
    BASE: 'normal',
    LOGO: 'italic',
  },
};

export const fonts = {
  // logo
  logotypeLarge: {
    'font-family': `${FONT.FAMILY.LOGO}`,
    'font-style': `${FONT.STYLE.LOGO}`,
    'font-size': `${FONT.SIZE.X_LARGE}`,
    'line-height': '72px',
    'letter-spacing': '-0.04em',
  },
  logotypeRegular: {
    'font-family': `${FONT.FAMILY.LOGO}`,
    'font-style': `${FONT.STYLE.LOGO}`,
    'font-weight': `${FONT.WEIGHT.MEDIUM}`,
    'font-size': `${FONT.SIZE.LARGE}`,
    'line-height': '40px',
    'letter-spacing': '-0.04em',
  },
  // link
  linkMedium: {
    'font-weight': '700',
    'font-size': '18px',
    'line-height': `${FONT.SIZE.LARGE}`,
  },
  linkSmall: {
    'font-weight': '700',
    'font-size': `${FONT.SIZE.BASE}`,
    'line-height': '28px',
  },
  linkXSmall: {
    'font-weight': '700',
    'font-size': `${FONT.SIZE.X_SMALL}`,
    'line-height': '20px',
  },
  // text
  textLarge: {
    'font-size': '24px',
    'line-height': '40px',
  },
  textMedium: {
    'font-size': `${FONT.SIZE.MEDIUM}`,
    'line-height': `${FONT.SIZE.LARGE}`,
  },
  textSmall: {
    'font-size': `${FONT.SIZE.BASE}`,
    'line-height': '28px',
  },
  textXSamll: {
    'font-weight': '500',
    'font-size': `${FONT.SIZE.X_SMALL}`,
    'line-height': '20px',
  },
  // Display
  displayRegular: {
    'font-size': `${FONT.SIZE.LARGE}`,
    'line-height': '48px',
  },
  DisplayBold: {
    'font-weight': '700',
    'font-size': `${FONT.SIZE.LARGE}`,
    'line-height': '48px',
  },
};
