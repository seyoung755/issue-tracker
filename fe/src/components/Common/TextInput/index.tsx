import { useState, InputHTMLAttributes } from 'react';

import * as S from './style';

// FIXME: success type 추가되도록 error 로직 변경, 현재 error 상태만 확인하기 위한 임시 로직

interface TextInputProps extends InputHTMLAttributes<HTMLInputElement> {
  label?: string;
  error?: string;
  textInputSize: 'large' | 'medium' | 'small';
}
export default function TextInput({
  label,
  error,
  textInputSize = 'large',
  ...rest
}: TextInputProps) {
  const [inputValue, setInputValue] = useState(rest.value || '');

  const changeHandler = (e: React.ChangeEvent<HTMLInputElement>) => {
    if (rest.onChange) {
      rest.onChange(e);
      return;
    }
    setInputValue(e.target.value);
  };

  return (
    <>
      <S.TextInput textInputSize={textInputSize} isError={!!error}>
        <S.InputWrapper textInputSize={textInputSize}>
          {label && (rest.value || inputValue) && <S.Label>{label}</S.Label>}
          <S.Input {...rest} onChange={changeHandler} value={rest.value || inputValue} />
        </S.InputWrapper>
      </S.TextInput>
      {textInputSize === 'large' && error && <S.Caption type={'error'}>{error}</S.Caption>}
    </>
  );
}
