import { useState } from 'react';

import TextInput from '@/components/Common/TextInput';

export default function TextInputs() {
  const [value, setValue] = useState('');
  return (
    <div>
      <TextInput
        textInputSize="large"
        label="large"
        placeholder="large"
        value={value}
        onChange={e => setValue(e.target.value)}
      />
      <TextInput textInputSize="medium" label="medium" placeholder="medium" />
      <TextInput textInputSize="small" label="small" placeholder="small" />
      <TextInput
        textInputSize="large"
        label="error large"
        placeholder="error large"
        error="error large"
      />
    </div>
  );
}
