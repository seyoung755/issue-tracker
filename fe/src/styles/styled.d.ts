import 'styled-components';

import { ColorTypes, FontTypes, IconSizeTypes } from './theme';

declare module 'styled-components' {
  export interface DefaultTheme {
    COLOR: ColorTypes;
    fonts: FontTypes;
    ICON_SIZE: IconSizeTypes;
  }
}
