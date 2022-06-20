import Button from '@/components/Common/Button';
import useForm from '@/hooks/useForm';

export default function LoginForm() {
  type Values = {
    id: string;
    password: string;
  };
  const initialValues = {
    id: '',
    password: '',
  };
  const onSubmit = async (values: Values) => {
    console.log(values);
  };
  const { values, isValid, handleChange, handleSubmit } = useForm<Values>({
    initialValues,
    onSubmit,
  });
  return (
    <form onSubmit={handleSubmit}>
      <label>
        <div>아이디</div>
        <input
          name="id"
          value={values.id}
          minLength={4}
          maxLength={16}
          placeholder="아이디"
          onChange={handleChange}
        />
      </label>
      <label>
        <div>비밀번호</div>
        <input
          name="password"
          type="password"
          value={values.password}
          minLength={6}
          maxLength={12}
          placeholder="비밀번호"
          onChange={handleChange}
        />
      </label>
      <Button onClick={() => {}}>아이디로 로그인</Button>
    </form>
  );
}
