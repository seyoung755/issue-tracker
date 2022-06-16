import 'styled-components';

import { ColorTypes, FontTypes } from './theme';

declare module 'styled-components' {
  export interface DefaultTheme {
    COLOR: ColorTypes;
    fonts: FontTypes;
  }
}
