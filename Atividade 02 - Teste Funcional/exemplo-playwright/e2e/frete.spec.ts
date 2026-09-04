import { test, expect } from '@playwright/test';

const casos = [
  { cep: '12345678', valor: '210', aceito: true, resultadoExperado: 'Frete grátis', classe: 'Valor acima de 200' },
  { cep: '87654321', valor: '200', aceito: true, resultadoExperado: 'Frete grátis', classe: 'Valor igual a 200' },
  { cep: '87654321', valor: '200,54', aceito: true, resultadoExperado: 'Frete grátis', classe: 'Valor decimal' },
  { cep: '87654321', valor: '190', aceito: true, resultadoExperado: 'Frete: R$ 15,00', classe: 'Valor abaixo de 200 e CEP iniciado com 8' },
  { cep: '12345678', valor: '190', aceito: true, resultadoExperado: 'Frete: R$ 25,00', classe: 'Valor abaixo de 200 e CEP não iniciado com 8' },
  { cep: '123456789', valor: '100', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'CEP com mais de 8 dígitos' },
  { cep: '123', valor: '100', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'CEP com menos de 8 dígitos' },
  { cep: 'teste', valor: '100', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'CEP como string' },
  { cep: '123452-7', valor: '100', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'CEP com caracter não numérico' },
  { cep: '', valor: '100', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'CEP vazio' },
  { cep: '12345678', valor: 'dez', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'Valor como string' },
  { cep: '12345678', valor: '100*', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'Valor com caracter não numérico' },
  { cep: '12345678', valor: '-100', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'Valor negativo' },
  { cep: '12345678', valor: '', aceito: false, resultadoExperado: 'Dados inválidos', classe: 'Valor vazio' },
];

for (const caso of casos) {
  test(`cep: ${caso.cep || '(vazia)'}, valor: ${caso.valor || '(vazia)'} — ${caso.classe}`, async ({ page }) => {
    await page.goto('http://127.0.0.1:3000/frete');
    await page.getByLabel('CEP').fill(caso.cep);
    await page.getByLabel('Valor do pedido').fill(caso.valor);
    await page.getByRole('button', { name: 'Calcular frete' }).click();

    const resultado = page.locator('#resultado');
    await expect(resultado).toBeVisible();
    await expect(resultado).toHaveText(caso.resultadoExperado);
    await expect(resultado).toHaveAttribute('role', caso.aceito ? 'status' : 'alert');
  });
}