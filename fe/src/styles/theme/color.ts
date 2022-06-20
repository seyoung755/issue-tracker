export const COLOR = {
  BLACK: '#14142B',
  GREY: {
    100: '#4E4B66',
    200: '#6E7191',
    300: '#A0A3BD',
    400: '#D9DBE9',
    500: '#EFF0F6',
    600: '#F7F7FC',
  },
  RED: {
    100: '#FFD1CF',
    200: '#FF3B30',
    300: '#C60B00',
  },
  GREEN: {
    100: '#DDFFE6',
    200: '#34C759',
    300: '#00A028',
  },
  BLUE: {
    100: '#C7EBFF',
    200: '#007AFF',
    300: '#004DE3',
  },
  DARK_BLUE: {
    100: '#CCD4FF',
    200: '#0025E7',
    300: '#020070',
  },
  WHITE: '#FEFEFE',
};

export const colors = {
  greyscale: {
    titleActive: COLOR.BLACK,
    body: COLOR.GREY[100],
    label: COLOR.GREY[200],
    placeholder: COLOR.GREY[300],
    line: COLOR.GREY[400],
    inputBackground: COLOR.GREY[500],
    background: COLOR.GREY[600],
    offWhite: COLOR.WHITE,
  },
  primary: {
    normal: COLOR.BLUE[200],
    light: COLOR.BLUE[100],
    dark: COLOR.BLUE[300],
  },
  secondary: {
    normal: COLOR.DARK_BLUE[200],
    light: COLOR.DARK_BLUE[100],
    dark: COLOR.DARK_BLUE[300],
  },
  error: {
    normal: COLOR.RED[200],
    light: COLOR.RED[100],
    dark: COLOR.RED[300],
  },
  success: {
    normal: COLOR.GREEN[200],
    light: COLOR.GREEN[100],
    dark: COLOR.GREEN[300],
  },
};
