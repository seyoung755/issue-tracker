import 'styled-components';

import { ColorsTypes, FontTypes, IconSizeTypes } from './theme';

declare module 'styled-components' {
  export interface DefaultTheme {
    colors: ColorsTypes;
    fonts: FontTypes;
    iconSizes: IconSizeTypes;
    buttonSizes: ButtonSizeTypes;
  }
}
